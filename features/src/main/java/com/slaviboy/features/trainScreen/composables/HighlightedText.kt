package com.slaviboy.features.trainScreen.composables

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.slaviboy.composeunits.sw
import com.slaviboy.features.homeScreen.ui.bannerLinkTextColor
import com.slaviboy.features.homeScreen.ui.bannerSubtitleColor
import com.slaviboy.features.trainScreen.entities.Highlight

@Composable
fun HighlightedText(
    text: String,
    highlights: List<Highlight>,
    modifier: Modifier = Modifier,
) {
    data class TextData(
        val text: String,
        val tag: String? = null,
        val data: String? = null,
        val onClick: ((data: AnnotatedString.Range<String>) -> Unit)? = null
    )

    val textData = mutableListOf<TextData>()
    if (highlights.isEmpty()) {
        textData.add(
            TextData(
                text = text
            )
        )
    } else {
        var startIndex = 0
        highlights.forEachIndexed { i, link ->
            val endIndex = text.indexOf(link.text)
            if (endIndex == -1) {
                throw Exception("Highlighted text mismatch")
            }
            textData.add(
                TextData(
                    text = text.substring(startIndex, endIndex)
                )
            )
            textData.add(
                TextData(
                    text = link.text,
                    tag = "${link.text}_TAG",
                    data = link.data,
                    onClick = {
                        link.onClick(it.item)
                    }
                )
            )
            startIndex = endIndex + link.text.length
            if (i == highlights.lastIndex && startIndex < text.length) {
                textData.add(
                    TextData(
                        text = text.substring(startIndex, text.length)
                    )
                )
            }
        }
    }

    val annotatedString = buildAnnotatedString {
        textData.forEach { linkTextData ->
            if (linkTextData.tag != null && linkTextData.data != null) {
                pushStringAnnotation(
                    tag = linkTextData.tag,
                    annotation = linkTextData.data,
                )
                withStyle(
                    style = SpanStyle(
                        color = bannerLinkTextColor
                    ),
                ) {
                    append(linkTextData.text)
                }
                pop()
            } else {
                append(linkTextData.text)
            }
        }
    }
    ClickableText(
        text = annotatedString,
        style = TextStyle(
            fontSize = 0.031.sw,
            fontWeight = FontWeight.Normal,
            color = bannerSubtitleColor,
            textAlign = TextAlign.Start
        ),
        onClick = { offset ->
            textData.forEach { annotatedStringData ->
                if (annotatedStringData.tag != null && annotatedStringData.data != null) {
                    annotatedString.getStringAnnotations(
                        tag = annotatedStringData.tag,
                        start = offset,
                        end = offset,
                    ).firstOrNull()?.let {
                        annotatedStringData.onClick?.invoke(it)
                    }
                }
            }
        },
        modifier = modifier
    )
}
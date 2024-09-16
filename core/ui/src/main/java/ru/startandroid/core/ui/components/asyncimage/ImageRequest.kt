package ru.startandroid.core.ui.components.asyncimage

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import coil.decode.SvgDecoder
import coil.request.ImageRequest

internal val svgDecoderFactory = SvgDecoder.Factory()

@Composable
fun rememberImageRequest(url: String): ImageRequest {
    val context = LocalContext.current
    return remember(url) {
        ImageRequest.Builder(context)
            .data(url)
            .decoderFactory(svgDecoderFactory)
            .build()
    }
}
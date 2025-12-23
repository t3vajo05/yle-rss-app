package com.example.rssapp.components

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
fun formatFinnishTime(pubDate: String): String
{
    return try
    {
        val parsed = ZonedDateTime.parse(
            pubDate,
            DateTimeFormatter.RFC_1123_DATE_TIME
        )

        val finnishFormatter = DateTimeFormatter.ofPattern(
            "d.M.yyyy HH:mm",
            Locale("fi", "FI")
        )

        parsed.format(finnishFormatter)
    }
    catch (e: Exception)
    {
        pubDate
    }
}

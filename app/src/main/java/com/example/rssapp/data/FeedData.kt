package com.example.rssapp.data

import com.example.rssapp.models.FeedOption

val allFeeds = listOf(
    // Pää-, tuoreimmat ja luetuimmat uutiset
    FeedOption("Pääuutiset", "https://yle.fi/rss/uutiset/paauutiset"),
    FeedOption("Tuoreimmat", "https://yle.fi/rss/uutiset/tuoreimmat"),
    FeedOption("Luetuimmat", "https://yle.fi/rss/uutiset/luetuimmat"),

    // Uutiset, urheilu ja muut sisällöt yhdessä
    FeedOption("Uutiset, urheilu ja muut", "https://yle.fi/rss/tuoreimmat"),

    // Aihekohtaiset syötteet
    FeedOption("Kotimaa", "https://yle.fi/rss/t/18-34837/fi"),
    FeedOption("Ulkomaat", "https://yle.fi/rss/t/18-34953/fi"),
    FeedOption("Talous", "https://yle.fi/rss/t/18-19274/fi"),
    FeedOption("Politiikka", "https://yle.fi/rss/t/18-38033/fi"),
    FeedOption("Kulttuuri", "https://yle.fi/rss/t/18-150067/fi"),
    FeedOption("Viihde", "https://yle.fi/rss/t/18-36066/fi"),
    FeedOption("Tiede", "https://yle.fi/rss/t/18-819/fi"),
    FeedOption("Luonto", "https://yle.fi/rss/t/18-35354/fi"),
    FeedOption("Terveys", "https://yle.fi/rss/t/18-35138/fi"),
    FeedOption("Liikenne", "https://yle.fi/rss/t/18-12/fi"),
    FeedOption("Kolumnit", "https://yle.fi/rss/t/18-215844/fi"),

    // Urheilu
    FeedOption("Urheilu", "https://yle.fi/rss/urheilu"),

    // Uutispodcast
    FeedOption("Uutispodcast", "https://areena.yle.fi/audio/1-61894955"),

    // Uutiset läheltäsi
    FeedOption("Etelä-Karjala", "https://yle.fi/rss/t/18-141372/fi"),
    FeedOption("Etelä-Pohjanmaa", "https://yle.fi/rss/t/18-146311/fi"),
    FeedOption("Etelä-Savo", "https://yle.fi/rss/t/18-141852/fi"),
    FeedOption("Kainuu", "https://yle.fi/rss/t/18-141399/fi"),
    FeedOption("Kanta-Häme", "https://yle.fi/rss/t/18-138727/fi"),
    FeedOption("Keski-Pohjanmaa", "https://yle.fi/rss/t/18-135629/fi"),
    FeedOption("Keski-Suomi", "https://yle.fi/rss/t/18-148148/fi"),
    FeedOption("Kymenlaakso", "https://yle.fi/rss/t/18-131408/fi"),
    FeedOption("Lappi", "https://yle.fi/rss/t/18-139752/fi"),
    FeedOption("Pirkanmaa", "https://yle.fi/rss/t/18-146831/fi"),
    FeedOption("Pohjanmaa", "https://yle.fi/rss/t/18-148149/fi"),
    FeedOption("Pohjois-Karjala", "https://yle.fi/rss/t/18-141936/fi"),
    FeedOption("Pohjois-Pohjanmaa", "https://yle.fi/rss/t/18-148154/fi"),
    FeedOption("Pohjois-Savo", "https://yle.fi/rss/t/18-141764/fi"),
    FeedOption("Päijät-Häme", "https://yle.fi/rss/t/18-141401/fi"),
    FeedOption("Satakunta", "https://yle.fi/rss/t/18-139772/fi"),
    FeedOption("Uusimaa", "https://yle.fi/rss/t/18-147345/fi"),
    FeedOption("Varsinais-Suomi", "https://yle.fi/rss/t/18-135507/fi"),

    // Yle Uutiset selkosuomeksi
    FeedOption("Selkouutiset", "https://yle.fi/rss/selkouutiset"),

    // Nyheter på svenska
    FeedOption("Senaste nytt", "https://svenska.yle.fi/rss/senaste-nytt"),
    FeedOption("Inrikes", "https://svenska.yle.fi/rss/inrikes"),
    FeedOption("Utrikes", "https://svenska.yle.fi/rss/utrikes"),
    FeedOption("Sport", "https://svenska.yle.fi/rss/sport"),
    FeedOption("Kultur", "https://svenska.yle.fi/rss/kultur"),
    FeedOption("Huvudstadsregionen", "https://svenska.yle.fi/rss/huvudstadsregionen"),
    FeedOption("Österbotten", "https://svenska.yle.fi/rss/osterbotten"),
    FeedOption("Åboland", "https://svenska.yle.fi/rss/aboland"),
    FeedOption("Östnyland", "https://svenska.yle.fi/rss/ostnyland"),
    FeedOption("Västnyland", "https://svenska.yle.fi/rss/vastnyland"),

    // Ođđasat davvisámegillii
    FeedOption("Yle Sápmi", "https://yle.fi/rss/sapmi"),

    // News In English
    FeedOption("Yle News", "https://yle.fi/rss/news"),

    // Новости по-русски
    FeedOption("Новости Yle", "https://yle.fi/rss/novosti"),

    // Новини українською
    FeedOption("Новини Yle", "https://yle.fi/rss/novyny"),

    // Uudizet karjalakse
    FeedOption("Yle Uudizet karjalakse", "https://yle.fi/rss/t/18-44136/fi")
)

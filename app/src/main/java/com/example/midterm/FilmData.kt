package com.example.midterm

data class Film(
    val title: String,
    val description: String,
    val rating: Float,
    val imageRes: Int
)

val filmList = listOf(
    Film(
        title = "Venom: The Last Dance",
        description = "Venom: The Last Dance is a 2024 American superhero film written and directed by Kelly Marcel, which features the Marvel Comics character Venom. A sequel to Venom and Let There Be Carnage, the fifth film in Sony's Spider-Man Universe, and the third and final installment of the Venom trilogy, it stars Tom Hardy as Eddie Brock and Venom, alongside Chiwetel Ejiofor, Juno Temple, Rhys Ifans, Stephen Graham, Peggy Lu, Clark Backo, Alanna Ubach, and Andy Serkis.",
        rating = 9.0f,
        imageRes = R.drawable.venomlastdance
    ),
    Film(
        title = "Spider man: Into the spider verse",
        description = "Spider-Man: Across the Spider-Verse is a 2023 American animated superhero film featuring the Marvel Comics character Miles Morales / Spider-Man, produced by Columbia Pictures and distributed by Sony Pictures Animation in association with Marvel Entertainment. It is a sequel to Spider-Man: Into the Spider-Verse (2018) and the second film in the Spider-Verse franchise, which is set in a shared multiverse of alternate universes called the \"Spider-Verse\".",
        rating = 9.2f,
        imageRes = R.drawable.morales
    ),
    Film(
        title = "Spider man: No way home",
        description = "Spider-Man: No Way Home is a 2021 American superhero film based on the Marvel Comics character Spider-Man, co-produced by Columbia Pictures and Marvel Studios, and distributed by Sony Pictures Releasing. It is the sequel to Spider-Man: Homecoming (2017) and Spider-Man: Far From Home (2019), and the 27th film in the Marvel Cinematic Universe (MCU). The film was directed by Jon Watts and written by Chris McKenna and Erik Sommers.",
        rating = 8.9f,
        imageRes = R.drawable.nobackhome
    ),
    Film(
        title = "The amazing Spider man",
        description = """"The New Spider-Man"[10] (eng. The Amazing Spider-Man is a 2012 
            American superhero film based on the Marvel Comics character Spider—Man. It is the fourth Spider-Man 
            film produced by Columbia Pictures and Marvel Entertainment, as well as the first film of the New Spider-Man 
            dilogy and the relaunch of Sam Raimi's Spider-Man trilogy.""".trimIndent(),
        rating = 9.9f,
        imageRes = R.drawable.garfield
)
)

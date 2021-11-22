package com.example.data.utils

import com.example.data.base.BaseRemoteEntity
import com.example.data.model.MovieSummaryEntity
import com.example.domain.model.MovieSummary

val dataEntity = MovieSummaryEntity(
    adult = false,
    backdrop_path = "path_bd",
    id = 0,
    original_language = "EN",
    original_title = "Test movie",
    overview = "Test overview",
    popularity = 4.0,
    poster_path = "path_ps",
    release_date = "2021",
    title = "Test movie",
    video = false,
    vote_average = 6.5,
    vote_count = 123,
    name = "Test movie",
    media_type = "Movie",
)
val domainModel = MovieSummary(
    adult = false,
    backdrop_path = "path_bd",
    id = 0,
    original_language = "EN",
    original_title = "Test movie",
    overview = "Test overview",
    popularity = 4.0,
    poster_path = "path_ps",
    release_date = "2021",
    title = "Test movie",
    video = false,
    vote_average = 6.5,
    vote_count = 123,
    name = "Test movie",
    media_type = "Movie",
)

const val testResponse = "{\n" +
        "  \"page\": 1,\n" +
        "  \"results\": [\n" +
        "    {\n" +
        "      \"video\": false,\n" +
        "      \"vote_average\": 8.1,\n" +
        "      \"overview\": \"The TRUE STORY of how Richard Williams served as a coach to his daughters Venus and Serena, who will soon become two of the most legendary tennis players in history.\",\n" +
        "      \"release_date\": \"2021-11-18\",\n" +
        "      \"adult\": false,\n" +
        "      \"backdrop_path\": \"/4kb7uR1UmXa33U6GB6F9xckFlhn.jpg\",\n" +
        "      \"id\": 614917,\n" +
        "      \"genre_ids\": [\n" +
        "        18\n" +
        "      ],\n" +
        "      \"vote_count\": 33,\n" +
        "      \"original_language\": \"en\",\n" +
        "      \"original_title\": \"King Richard\",\n" +
        "      \"poster_path\": \"/qQl0QS5P15vVzUcaP8rAqxbQ6Wp.jpg\",\n" +
        "      \"title\": \"King Richard\",\n" +
        "      \"popularity\": 237.028,\n" +
        "      \"media_type\": \"movie\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"release_date\": \"2021-09-29\",\n" +
        "      \"adult\": false,\n" +
        "      \"backdrop_path\": \"/u5Fp9GBy9W8fqkuGfLBuuoJf57Z.jpg\",\n" +
        "      \"id\": 370172,\n" +
        "      \"genre_ids\": [\n" +
        "        12,\n" +
        "        28,\n" +
        "        53\n" +
        "      ],\n" +
        "      \"original_language\": \"en\",\n" +
        "      \"original_title\": \"No Time to Die\",\n" +
        "      \"poster_path\": \"/iUgygt3fscRoKWCV1d0C7FbM9TP.jpg\",\n" +
        "      \"vote_count\": 1984,\n" +
        "      \"video\": false,\n" +
        "      \"vote_average\": 7.6,\n" +
        "      \"title\": \"No Time to Die\",\n" +
        "      \"overview\": \"Bond has left active service and is enjoying a tranquil life in Jamaica. His peace is short-lived when his old friend Felix Leiter from the CIA turns up asking for help. The mission to rescue a kidnapped scientist turns out to be far more treacherous than expected, leading Bond onto the trail of a mysterious villain armed with dangerous new technology.\",\n" +
        "      \"popularity\": 4467.007,\n" +
        "      \"media_type\": \"movie\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"id\": 580489,\n" +
        "      \"overview\": \"After finding a host body in investigative reporter Eddie Brock, the alien symbiote must face a new enemy, Carnage, the alter ego of serial killer Cletus Kasady.\",\n" +
        "      \"release_date\": \"2021-09-30\",\n" +
        "      \"title\": \"Venom: Let There Be Carnage\",\n" +
        "      \"adult\": false,\n" +
        "      \"backdrop_path\": \"/70nxSw3mFBsGmtkvcs91PbjerwD.jpg\",\n" +
        "      \"genre_ids\": [\n" +
        "        878,\n" +
        "        28,\n" +
        "        12\n" +
        "      ],\n" +
        "      \"vote_count\": 2028,\n" +
        "      \"original_language\": \"en\",\n" +
        "      \"original_title\": \"Venom: Let There Be Carnage\",\n" +
        "      \"poster_path\": \"/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg\",\n" +
        "      \"vote_average\": 6.8,\n" +
        "      \"video\": false,\n" +
        "      \"popularity\": 4813.214,\n" +
        "      \"media_type\": \"movie\"\n" +
        "    }\n" +
        "  ],\n" +
        "  \"total_pages\": 1000,\n" +
        "  \"total_results\": 20000\n" +
        "}"


fun createList(): List<MovieSummaryEntity> {
    val item1 = MovieSummaryEntity(
        adult = false,
        backdrop_path = "/4kb7uR1UmXa33U6GB6F9xckFlhn.jpg",
        id = 614917,
        original_language = "en",
        original_title = "King Richard",
        overview = "The TRUE STORY of how Richard Williams served as a coach to his daughters Venus and Serena, who will soon become two of the most legendary tennis players in history.",
        popularity = 237.028,
        poster_path = "/qQl0QS5P15vVzUcaP8rAqxbQ6Wp.jpg",
        release_date = "2021-11-18",
        title = "King Richard",
        video = false,
        vote_average = 8.1,
        vote_count = 33,
        name = null,
        media_type = "movie",
    )
    val item2 = MovieSummaryEntity(
        adult = false,
        backdrop_path = "/u5Fp9GBy9W8fqkuGfLBuuoJf57Z.jpg",
        id = 370172,
        original_language = "en",
        original_title = "No Time to Die",
        overview = "Bond has left active service and is enjoying a tranquil life in Jamaica. His peace is short-lived when his old friend Felix Leiter from the CIA turns up asking for help. The mission to rescue a kidnapped scientist turns out to be far more treacherous than expected, leading Bond onto the trail of a mysterious villain armed with dangerous new technology.",
        popularity = 4467.007,
        poster_path = "/iUgygt3fscRoKWCV1d0C7FbM9TP.jpg",
        release_date = "2021-09-29",
        title = "No Time to Die",
        video = false,
        vote_average = 7.6,
        vote_count = 1984,
        name = null,
        media_type = "movie",
    )
    val item3 = MovieSummaryEntity(
        adult = false,
        backdrop_path = "/70nxSw3mFBsGmtkvcs91PbjerwD.jpg",
        id = 580489,
        original_language = "en",
        original_title = "Venom: Let There Be Carnage",
        overview = "After finding a host body in investigative reporter Eddie Brock, the alien symbiote must face a new enemy, Carnage, the alter ego of serial killer Cletus Kasady.",
        popularity = 4813.214,
        poster_path = "/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg",
        release_date = "2021-09-30",
        title = "Venom: Let There Be Carnage",
        video = false,
        vote_average = 6.8,
        vote_count = 2028,
        name = null,
        media_type = "movie",
    )
    return listOf(item1, item2, item3)
}

fun createListDomainModel(): List<MovieSummary> {
    val item1 = MovieSummary(
        adult = false,
        backdrop_path = "/4kb7uR1UmXa33U6GB6F9xckFlhn.jpg",
        id = 614917,
        original_language = "en",
        original_title = "King Richard",
        overview = "The TRUE STORY of how Richard Williams served as a coach to his daughters Venus and Serena, who will soon become two of the most legendary tennis players in history.",
        popularity = 237.028,
        poster_path = "/qQl0QS5P15vVzUcaP8rAqxbQ6Wp.jpg",
        release_date = "2021-11-18",
        title = "King Richard",
        video = false,
        vote_average = 8.1,
        vote_count = 33,
        name = null,
        media_type = "movie",
    )
    val item2 = MovieSummary(
        adult = false,
        backdrop_path = "/u5Fp9GBy9W8fqkuGfLBuuoJf57Z.jpg",
        id = 370172,
        original_language = "en",
        original_title = "No Time to Die",
        overview = "Bond has left active service and is enjoying a tranquil life in Jamaica. His peace is short-lived when his old friend Felix Leiter from the CIA turns up asking for help. The mission to rescue a kidnapped scientist turns out to be far more treacherous than expected, leading Bond onto the trail of a mysterious villain armed with dangerous new technology.",
        popularity = 4467.007,
        poster_path = "/iUgygt3fscRoKWCV1d0C7FbM9TP.jpg",
        release_date = "2021-09-29",
        title = "No Time to Die",
        video = false,
        vote_average = 7.6,
        vote_count = 1984,
        name = null,
        media_type = "movie",
    )
    val item3 = MovieSummary(
        adult = false,
        backdrop_path = "/70nxSw3mFBsGmtkvcs91PbjerwD.jpg",
        id = 580489,
        original_language = "en",
        original_title = "Venom: Let There Be Carnage",
        overview = "After finding a host body in investigative reporter Eddie Brock, the alien symbiote must face a new enemy, Carnage, the alter ego of serial killer Cletus Kasady.",
        popularity = 4813.214,
        poster_path = "/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg",
        release_date = "2021-09-30",
        title = "Venom: Let There Be Carnage",
        video = false,
        vote_average = 6.8,
        vote_count = 2028,
        name = null,
        media_type = "movie",
    )
    return listOf(item1, item2, item3)
}

fun createResponseObject() = BaseRemoteEntity(
    results = createList(),
    page = 1,
    total_results = 20000,
)

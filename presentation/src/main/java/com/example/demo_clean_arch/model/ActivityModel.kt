package com.example.demo_clean_arch.model

import androidx.core.os.bundleOf

data class ActivityModel(

    override val id: Int? = 0,
    val accessibility: Double?,
    val activity: String?,
    val key: String?,
    val link: String?,
    val participants: Int?,
    val price: Double?,
    val type: String?,
) : PresentationModel() {

    fun toBundle() = bundleOf(
        "id" to id,
        "accessibility" to accessibility,
        "activity" to activity,
        "key" to key,
        "link" to link,
        "participants" to participants,
        "price" to price,
        "type" to type,
    )

    val displayString
        get() = run {
            "id: ${id}\nAccessibility: ${accessibility}\nActivity: ${activity}\nKey: ${key}\nLink: ${link}\nParticipants: ${participants}\nPrice: ${price}\nType: $type"
        }
}

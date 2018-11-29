package com.example.mvvmstructure.language

/**
 * Created by PrewSitthirat on 2018-11-29.
 */

fun Label.string(): String {
    return Word.getMessage(label = this)!!
}

enum class Label {
    DIALOG_OK,
    DIALOG_CANCEL
}

class Word {
    companion object {
        private val map: Map<Label, Map<String, String>>
            get() = mapOf(
                Label.DIALOG_OK to mapOf(Language.EN to "OK", Language.TH to "ตกลง"),
                Label.DIALOG_CANCEL to mapOf(Language.EN to "CANCEL", Language.TH to "ยกเลิก")
            )

        fun getMessage(label: Label): String? {
            return map[label]?.get(Language.language)
        }
    }
}
package com.plugin.showcaserestfullapi.model

import org.springframework.web.multipart.MultipartFile
import javax.validation.constraints.NotBlank

data class UpdateShowcaseRequest(
    @field:NotBlank
    val title : String?,
    @field:NotBlank
    val image : MultipartFile,
    @field:NotBlank
    val description: String?,
    @field:NotBlank
    val idCategory : Int
)

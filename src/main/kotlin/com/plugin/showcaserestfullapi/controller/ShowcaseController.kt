package com.plugin.showcaserestfullapi.controller

import com.plugin.showcaserestfullapi.helper.BaseResponse
import com.plugin.showcaserestfullapi.model.CreateShowcaseRequest
import com.plugin.showcaserestfullapi.model.ListShowcaseRequest
import com.plugin.showcaserestfullapi.model.ShowcaseResponse
import com.plugin.showcaserestfullapi.service.ShowcaseService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ShowcaseController (val showcaseService: ShowcaseService){

    @PostMapping("/api/showcase")
    fun createShowcase(@ModelAttribute createShowcaseRequest: CreateShowcaseRequest) : BaseResponse<ShowcaseResponse> {
        val showcaseResponse =  showcaseService.create(createShowcaseRequest)
        return BaseResponse(
            code = 200,
            status = "Create Showcase Success",
            data = showcaseResponse
        )
    }

    @GetMapping(
        value = ["api/showcase/{idShowcase}"],
        produces = ["application/json"]
    )
    fun getShowcase(@PathVariable("idShowcase") id: Int) : BaseResponse<ShowcaseResponse> {
        val showcaseResponse = showcaseService.get(id)
        return BaseResponse(
            code = 200,
            status = "Get Showcase Success",
            data = showcaseResponse
        )
    }

    @GetMapping(
        value = ["api/showcases"],
        produces = ["application/json"]
    )
    fun listShowcases(@RequestParam(value = "page", defaultValue = "0") page: Int,
                      @RequestParam(value = "size", defaultValue = "2") size: Int)
    : BaseResponse<List<ShowcaseResponse>> {
        val request = ListShowcaseRequest(page = page, size = size)
        val showcaseResponse = showcaseService.list(request)
        return BaseResponse (
            code = 200,
            status = "List Showcase Success",
            data = showcaseResponse
        )
    }

    @DeleteMapping(value = ["api/showcase/{idShowcase}"])
    fun deleteShowcase(@PathVariable("idShowcase") id: Int) : BaseResponse<Unit> {
        val showcaseResponse = showcaseService.delete(id)
        return BaseResponse(
            code = 204,
            status = "Delete Showcase Success",
            data = showcaseResponse
        )
    }
    @PutMapping(value = ["api/showcase/{idShowcase}"])
    fun putShowcase(@PathVariable("idShowcase")id: Int, updateShowcaseRequest: CreateShowcaseRequest) : BaseResponse<ShowcaseResponse>{
        val showcaseResponse = showcaseService.put(id, updateShowcaseRequest)
        return BaseResponse(
            code = 204,
            status = "Update Showcase Success",
            data = showcaseResponse
        )
    }

}
package src.com.hey

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HeyController {

    @GetMapping("/")
    fun hey() : String {
        return "/index.html"
    }
}
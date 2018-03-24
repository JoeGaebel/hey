package src.com.hey

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import java.io.File
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component
import java.io.IOException
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.ServletException
import javax.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired


@Controller
class HeyController {
    private val MP4_FILE = File("src/main/resources/static/Hey!.mp4")

    @Autowired
    private val handler: MyResourceHttpRequestHandler? = null

    // supports byte-range requests
    @GetMapping("/video")
    @Throws(ServletException::class, IOException::class)
    fun home(
            request: HttpServletRequest,
            response: HttpServletResponse
    ) {

        request.setAttribute(MyResourceHttpRequestHandler.ATTR_FILE, MP4_FILE)
        handler!!.handleRequest(request, response)
    }

    // does not support byte-range requests
    @GetMapping(path = arrayOf("/plain"), produces = arrayOf("video/mp4"))
    fun plain(): FileSystemResource {
        return FileSystemResource(MP4_FILE)
    }

    @GetMapping("/")
    fun hey(): String {
        return "/index.html"
    }
}

@Component
internal class MyResourceHttpRequestHandler : ResourceHttpRequestHandler() {

    @Throws(IOException::class)
    override fun getResource(request: HttpServletRequest): Resource {
        val file = request.getAttribute(ATTR_FILE) as File
        return FileSystemResource(file)
    }

    companion object {
        val ATTR_FILE = MyResourceHttpRequestHandler::class.java.name + ".file"
    }
}
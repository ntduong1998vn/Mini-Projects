package ntduong.galleryservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "image-service", url = "localhost:8200")
public interface ImageClient {

    @RequestMapping(method = RequestMethod.GET, value = "/images")
    List<Object> getImages();
}

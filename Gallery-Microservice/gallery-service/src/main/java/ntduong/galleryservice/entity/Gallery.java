package ntduong.galleryservice.entity;

import lombok.Data;

import java.util.List;

@Data
public class Gallery {
    private Integer id;
    private List<Object> images;
}

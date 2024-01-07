package com.tpanh.dinehub.service.impl;

import com.tpanh.dinehub.dto.TagDTO;
import com.tpanh.dinehub.entity.Tag;

import java.util.List;

public interface ITagService {
    List<Tag> getAllTags();
    Tag getTagById(Integer id) throws Exception;
    Tag createTag(TagDTO tag);
    Tag updateTag(Integer id, TagDTO tag) throws Exception;
    void deleteTag(Integer id);
}

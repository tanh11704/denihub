package com.tpanh.dinehub.service;

import com.tpanh.dinehub.dto.TagDTO;
import com.tpanh.dinehub.entity.Tag;
import com.tpanh.dinehub.exception.DataNotFoundException;
import com.tpanh.dinehub.reponsitory.TagRepository;
import com.tpanh.dinehub.service.impl.ITagService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService implements ITagService {

    @Autowired
    TagRepository tagRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag getTagById(Integer id) throws Exception {
        Tag tag = tagRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("Tag not found")
        );
        return tag;
    }

    @Override
    public Tag createTag(TagDTO tag) {
        Tag newTag = new Tag();
        modelMapper.map(tag, newTag);
        return tagRepository.save(newTag);
    }

    @Override
    public Tag updateTag(Integer id, TagDTO tag) throws Exception {
        Tag tagToUpdate = tagRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("Tag not found")
        );
        modelMapper.map(tag, tagToUpdate);
        return tagRepository.save(tagToUpdate);
    }

    @Override
    public void deleteTag(Integer id) {
        Optional<Tag> optionalTag = tagRepository.findById(id);
        optionalTag.ifPresent(tag -> tagRepository.delete(tag));
    }
}

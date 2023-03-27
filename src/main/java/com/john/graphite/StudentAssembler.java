package com.john.graphite;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.john.graphite.model.Student;

@Component
public class StudentAssembler implements RepresentationModelAssembler<Student, EntityModel<Student>> {

    @Override
    public EntityModel<Student> toModel(Student entity) {
//        RepresentationModel<?> model = new RepresentationModel<>();
        EntityModel<Student> entityModel = EntityModel.of(entity);
        entityModel.add(Link.of("/api/students/" + entity.getId()).withSelfRel());
        entityModel.add(Link.of("/api/students").withRel("students"));

        return entityModel;
    }

    public EntityModel<Student> toModel(Student entity, boolean showLinks) {
        EntityModel<Student> entityModel = EntityModel.of(entity);
        if (showLinks) {
        	entityModel.add(Link.of("/api/students/" + entity.getId()).withSelfRel());
        	entityModel.add(Link.of("/api/students").withRel("students"));
        }
        return entityModel;
    }

}

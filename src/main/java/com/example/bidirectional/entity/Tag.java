package com.example.bidirectional.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NamedQueries(value = {
        @NamedQuery(name = Tag.QUERY_GET_TAG_ATTRIBUTE_BY_ID,
                query = "SELECT a FROM Tag a WHERE a.id = :id")
})
@Entity(name = "Tag")
@Table(name = "tag")
//@NaturalIdCache
//@Cache(
//        usage = CacheConcurrencyStrategy.READ_WRITE
//)
public class Tag {

    public static final String QUERY_GET_TAG_ATTRIBUTE_BY_ID = "SessionAttribute.getTagAttributeById";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NaturalId
    private String name;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "tag",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PostTag> posts = new ArrayList<>();

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PostTag> getPosts() {
        return posts;
    }

    public void setPosts(List<PostTag> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(name, tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

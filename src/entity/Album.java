package entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Album {
    private int id;
    private String name;
    private int artistId;
    private int releaseYear;
    private Album albumByArtistId;
    private Collection<Album> albumsById;
    private Collection<ChartPosition> chartPositionsById;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "artist_ID")
    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    @Basic
    @Column(name = "release_year")
    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return id == album.id &&
                artistId == album.artistId &&
                releaseYear == album.releaseYear &&
                Objects.equals(name, album.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, artistId, releaseYear);
    }

    @ManyToOne
    @JoinColumn(name = "artist_ID", referencedColumnName = "ID", nullable = false)
    public Album getAlbumByArtistId() {
        return albumByArtistId;
    }

    public void setAlbumByArtistId(Album albumByArtistId) {
        this.albumByArtistId = albumByArtistId;
    }

    @OneToMany(mappedBy = "albumByArtistId")
    public Collection<Album> getAlbumsById() {
        return albumsById;
    }

    public void setAlbumsById(Collection<Album> albumsById) {
        this.albumsById = albumsById;
    }

    @OneToMany(mappedBy = "albumByAlbumId")
    public Collection<ChartPosition> getChartPositionsById() {
        return chartPositionsById;
    }

    public void setChartPositionsById(Collection<ChartPosition> chartPositionsById) {
        this.chartPositionsById = chartPositionsById;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artistId=" + artistId +
                ", releaseYear=" + releaseYear +
                '}';
    }
}

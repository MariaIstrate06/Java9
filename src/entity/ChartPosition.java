package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "chart_position", schema = "music_albums_lab", catalog = "")
public class ChartPosition {
    private int id;
    private int chartId;
    private int albumId;
    private Integer position;
    private Chart chartByChartId;
    private Album albumByAlbumId;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "chart_ID")
    public int getChartId() {
        return chartId;
    }

    public void setChartId(int chartId) {
        this.chartId = chartId;
    }

    @Basic
    @Column(name = "album_ID")
    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    @Basic
    @Column(name = "position")
    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChartPosition that = (ChartPosition) o;
        return id == that.id &&
                chartId == that.chartId &&
                albumId == that.albumId &&
                Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chartId, albumId, position);
    }

    @ManyToOne
    @JoinColumn(name = "chart_ID", referencedColumnName = "ID", nullable = false)
    public Chart getChartByChartId() {
        return chartByChartId;
    }

    public void setChartByChartId(Chart chartByChartId) {
        this.chartByChartId = chartByChartId;
    }

    @ManyToOne
    @JoinColumn(name = "album_ID", referencedColumnName = "ID", nullable = false)
    public Album getAlbumByAlbumId() {
        return albumByAlbumId;
    }

    public void setAlbumByAlbumId(Album albumByAlbumId) {
        this.albumByAlbumId = albumByAlbumId;
    }
}

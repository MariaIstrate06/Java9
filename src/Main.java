import repo.ArtistRepository;

public class Main {
    public static void main(String[] args) {
        System.out.println(ArtistRepository.findByID(1));
    }
}

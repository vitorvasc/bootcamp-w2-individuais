package aula4.lachiqui;

public class FogosArtificio {
    private final String barulho;

    public FogosArtificio(String barulho) {
        this.barulho = barulho;
    }

    public void explodir() {
        System.out.println("Fogos: *" + this.barulho + "*");
    }
}

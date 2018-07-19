package ru.sbt.patterns1.structural;


public class AdapterApp {
    public static void main(String[] args) {
        VectorGraphicsInterface g1 = new VectorAdapterFromRaster();
        g1.drawLine();
        g1.drawSquare();

        VectorGraphicsInterface g2 = new VectorAdapterFromRaster2();
        g2.drawLine();
        g2.drawSquare();
    }
}


interface VectorGraphicsInterface{
    void drawLine();
    void drawSquare();
}

class RasterGraphics {
    void drawRasterLine(){
        System.out.println("draw line");
    }
    void drawRasterSquare(){
        System.out.println("draw square");
    }
}

//через наследование
class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface{
    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}

//через композицию
class VectorAdapterFromRaster2 implements VectorGraphicsInterface{
    RasterGraphics rg = new RasterGraphics();

    public VectorAdapterFromRaster2() {
    }

    @Override
    public void drawLine() {
        rg.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        rg.drawRasterSquare();
    }
}

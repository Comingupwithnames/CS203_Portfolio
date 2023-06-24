
/**
 * This filter will detect sharp changes in the colors of pixels and set them to black
 *
 * @author Comingupwithnames
 * @version 1
 */
public class EdgeFilter implements Filter
{

    /**
     * A filter method that identifies edges and sets them to black
     *
     * @param  PixelImage image to modify
     * @return    void
     */
    public void filter(PixelImage image)
    {
        Pixel[][] data = image.getData();        
        int row;
        int col;
        Pixel[][] edgePixelArray = new Pixel[image.getHeight()][image.getWidth()];

        for(row = 1; row<image.getHeight()-1;row++)
        {
            for(col = 1; col<image.getWidth()-1;col++)
            {            
                Pixel currentPixel = data[row][col];

                //Below, the surrounding pixels are set to corresponding rows and columns
                Pixel topLeftPixel = data[row-1][col-1];
                Pixel leftPixel = data[row][col-1];
                Pixel bottomLeftPixel = data[row+1][col-1];            
                Pixel topPixel = data[row+1][col];           
                Pixel bottomPixel = data[row-1][col];           
                Pixel topRightPixel = data[row-1][col+1];               
                Pixel rightPixel = data[row][col+1];              
                Pixel bottomRightPixel = data[row+1][col+1];

                if((currentPixel.getRed() - topLeftPixel.getRed() > 10 || currentPixel.getRed() - topLeftPixel.getRed() < -10) || (currentPixel.getGreen()-topLeftPixel.getGreen() > 10 ||currentPixel.getGreen()-topLeftPixel.getGreen() < -10)|| (currentPixel.getBlue()-topLeftPixel.getBlue() > 10 ||currentPixel.getBlue()-topLeftPixel.getBlue() < -10))
                {
                    edgePixelArray[row][col]=currentPixel;     
                }
                else if((currentPixel.getRed() - topRightPixel.getRed() > 10 || currentPixel.getRed() - topRightPixel.getRed() < -10) || (currentPixel.getGreen()-topRightPixel.getGreen() > 10 ||currentPixel.getGreen()-topRightPixel.getGreen() < -10)|| (currentPixel.getBlue()-topRightPixel.getBlue() > 10 ||currentPixel.getBlue()-topRightPixel.getBlue() < -10))
                {
                    edgePixelArray[row][col]=currentPixel;
                }
                else if((currentPixel.getRed() - topPixel.getRed() > 10 || currentPixel.getRed() - topPixel.getRed() < -10) || (currentPixel.getGreen()-topPixel.getGreen() > 10 ||currentPixel.getGreen()-topPixel.getGreen() < -10)|| (currentPixel.getBlue()-topPixel.getBlue() > 10 ||currentPixel.getBlue()-topPixel.getBlue() < -10))
                {
                    edgePixelArray[row][col]=currentPixel;
                }
                else if((currentPixel.getRed() - leftPixel.getRed() > 10 || currentPixel.getRed() - leftPixel.getRed() < -10) || (currentPixel.getGreen()-leftPixel.getGreen() > 10 ||currentPixel.getGreen()-leftPixel.getGreen() < -10)|| (currentPixel.getBlue()-leftPixel.getBlue() > 10 ||currentPixel.getBlue()-leftPixel.getBlue() < -10))
                {
                    edgePixelArray[row][col]=currentPixel;
                }
                else if((currentPixel.getRed() - rightPixel.getRed() > 10 || currentPixel.getRed() - rightPixel.getRed() < -10) || (currentPixel.getGreen()-rightPixel.getGreen() > 10 ||currentPixel.getGreen()-rightPixel.getGreen() < -10)|| (currentPixel.getBlue()-rightPixel.getBlue() > 10 ||currentPixel.getBlue()-rightPixel.getBlue() < -10))
                {
                    edgePixelArray[row][col]=currentPixel;
                }
                else if((currentPixel.getRed() - bottomPixel.getRed() > 10 || currentPixel.getRed() - bottomPixel.getRed() < -10) || (currentPixel.getGreen()-bottomPixel.getGreen() > 10 ||currentPixel.getGreen()-bottomPixel.getGreen() < -10)|| (currentPixel.getBlue()-bottomPixel.getBlue() > 10 ||currentPixel.getBlue()-bottomPixel.getBlue() < -10))
                {
                    edgePixelArray[row][col]=currentPixel;
                }
                else if((currentPixel.getRed() - bottomLeftPixel.getRed() > 10 || currentPixel.getRed() - bottomLeftPixel.getRed() < -10) || (currentPixel.getGreen()-bottomLeftPixel.getGreen() > 10 ||currentPixel.getGreen()-bottomLeftPixel.getGreen() < -10)|| (currentPixel.getBlue()-bottomLeftPixel.getBlue() > 10 ||currentPixel.getBlue()-bottomLeftPixel.getBlue() < -10))
                {
                    edgePixelArray[row][col]=currentPixel;
                }
                else if((currentPixel.getRed() - bottomRightPixel.getRed() > 10 || currentPixel.getRed() - bottomRightPixel.getRed() < -10) || (currentPixel.getGreen()-bottomRightPixel.getGreen() > 10 ||currentPixel.getGreen()-bottomRightPixel.getGreen() < -10)|| (currentPixel.getBlue()-bottomRightPixel.getBlue() > 10 ||currentPixel.getBlue()-bottomRightPixel.getBlue() < -10))
                {
                    edgePixelArray[row][col]=currentPixel;
                }
            }
        }
        for(row = 0; row<image.getHeight();row++)
        {
            for(col = 0; col<image.getWidth();col++)
            {
                Pixel currentPixel = edgePixelArray[row][col];
                if(currentPixel != null)
                {

                    Pixel edgePixel = data[row][col];
                    edgePixel.setAllColors(0,0,0);  
                }
                else
                {
                    Pixel newPixel = data[row][col];
                    newPixel.setAllColors(255,255,255);   
                }
            }
        }
        image.setData(data);
    }
}

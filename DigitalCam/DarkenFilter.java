
/**
 * A filter that darkens the entire image by a set amount
 *
 * @author Comingupwithnames
 * @version 1
 */
public class DarkenFilter implements Filter
{
    
    /**
     * A method for filter that darkens the image
     *
     * @param  PixelImage image to modify
     * @return    void
     */
    public void filter(PixelImage image)
    {
        Pixel[][] data = image.getData();
        for(int row = 0; row<image.getHeight();row++)
        {
            for(int col = 0; col<image.getWidth();col++)
            {
                Pixel currentPixel = data[row][col];
                int redVal = currentPixel.getRed();//Retrieves the red value RGB of the pixel
                int greenVal = currentPixel.getGreen();//Retrieves the green value RGB of the pixel
                int blueVal = currentPixel.getBlue();//Retrieves the blue value RGB of the pixel
                redVal -=10;//Increments the value for red down by 10
                greenVal -= 10;//Increments the value for green down by 10
                blueVal -= 10;//Increments the value for blue down by 10
                if(redVal==0||redVal<0)//Checks to see if the value is equal to 0 or if the arithmetic made the value less than 0 then sets the value to 0
                {
                    redVal = 0;  
                }
                if(greenVal==0||greenVal<0)//Checks to see if the value is equal to 0 or if the arithmetic made the value less than 0 then sets the value to 0
                {
                    greenVal = 0;   
                }
                if(blueVal==0||blueVal<0)//Checks to see if the value is equal to 0 or if the arithmetic made the value less than 0 then sets the value to 0
                {
                    blueVal = 0;   
                }
                currentPixel.setAllColors(redVal,greenVal,blueVal);

            }
        }
        image.setData(data); 
    }
}

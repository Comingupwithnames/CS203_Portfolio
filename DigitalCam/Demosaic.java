
/**
 * A filter that demosaics the current image from the digital camera filter
 *
 * @author Comingupwithnames
 * @version 1
 */
public class Demosaic implements Filter
{
    /**
     * A method for filter that demosaics the image
     *
     * @param  PixelImage image to modify
     * @return    void
     */
    //TODO: Revisit edge cases to smooth such cases out
    public void filter(PixelImage image)
    {
        Pixel[][] data = image.getData();
        int totalRedPixelColor=0; 
        int totalBluePixelColor=0; 
        int totalGreenPixelColor=0; 

        for(int row = 1; row < image.getHeight()-1; row++)
        {
            for(int col = 1; col < image.getWidth()-1; col++)
            {
                Pixel currentPixel = data[row][col];

                //Below, the surrounding pixels are set to corresponding rows and columns

                Pixel topLeftPixel = data[row-1][col-1];
                Pixel leftPixel = data[row][col-1];
                Pixel bottomLeftPixel = data[row+1][col-1];            
                Pixel topPixel = data[row-1][col];           
                Pixel bottomPixel = data[row+1][col];           
                Pixel topRightPixel = data[row-1][col+1];               
                Pixel rightPixel = data[row][col+1];              
                Pixel bottomRightPixel = data[row+1][col+1];

                if(currentPixel.getDigCamColor() == 1)//Checks to see if the DigCamColor is red
                {
                    totalRedPixelColor=currentPixel.getRed(); 
                    totalBluePixelColor=topLeftPixel.getBlue() + topRightPixel.getBlue() + bottomLeftPixel.getBlue() + bottomRightPixel.getBlue(); 
                    totalGreenPixelColor=topPixel.getGreen() + leftPixel.getGreen() + bottomPixel.getGreen() + rightPixel.getGreen();

                    currentPixel.setAllColors(totalRedPixelColor, totalGreenPixelColor/4,totalBluePixelColor/4);
                }

                else if(currentPixel.getDigCamColor() == 2)//Checks to see if the DigCamColor is green
                {
                    //Green has two difference cases where either blue is on top or red is on top, this checks to see if the top pixel is blue or red
                    if(topPixel.getDigCamColor() == 3)
                    {
                        totalRedPixelColor=leftPixel.getRed() + rightPixel.getRed(); 
                        totalBluePixelColor=bottomPixel.getBlue() + topPixel.getBlue(); 
                        totalGreenPixelColor=topLeftPixel.getGreen() + topRightPixel.getGreen() + bottomLeftPixel.getGreen() + bottomRightPixel.getGreen()+currentPixel.getGreen();

                        currentPixel.setAllColors(totalRedPixelColor/2, totalGreenPixelColor/5,totalBluePixelColor/2);
                    }
                    else
                    {
                        totalRedPixelColor=topPixel.getRed() + bottomPixel.getRed(); 
                        totalBluePixelColor=leftPixel.getBlue() + rightPixel.getBlue();
                        totalGreenPixelColor=topLeftPixel.getGreen() + topRightPixel.getGreen() + bottomLeftPixel.getGreen() + bottomRightPixel.getGreen()+currentPixel.getGreen();

                        currentPixel.setAllColors(totalRedPixelColor/2, totalGreenPixelColor/5,totalBluePixelColor/2);  
                    }

                }
                else if(currentPixel.getDigCamColor() == 3)//Checks to see if the DigCamColor is blue
                {
                    totalRedPixelColor=topLeftPixel.getRed() + topRightPixel.getRed() + bottomLeftPixel.getRed() + bottomRightPixel.getRed();
                    totalBluePixelColor=currentPixel.getBlue();
                    totalGreenPixelColor=topPixel.getGreen() + leftPixel.getGreen() + bottomPixel.getGreen() + rightPixel.getGreen();

                    currentPixel.setAllColors(totalRedPixelColor/4, totalGreenPixelColor/4,totalBluePixelColor);  
                }

                //This sets all the total colors back to zero for another run through
                totalRedPixelColor=0; 
                totalBluePixelColor=0; 
                totalGreenPixelColor=0; 
            } 
        }
        image.setData(data);
    }
}

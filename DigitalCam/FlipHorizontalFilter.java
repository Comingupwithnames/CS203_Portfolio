
/**
 * Filter that flips the image horizontally
 *
 * @author Comingupwithnames
 * @version 1
 */
public class FlipHorizontalFilter implements Filter
{
    /**
     * filter
     * flips pixel image vertically around horizontal
     * center line
     * @param image The PixelImage object to modify
     */ 
    public void filter(PixelImage image)
    {
        Pixel[][] imageData = image.getData(); //gets the image data

        for(int row = 0; row<image.getHeight() ;row++)
        {
            for(int col = 0; col<image.getWidth()/2; col++)
            {
                //swap values across the vertical center line
                Pixel temp = imageData[row][col];
                imageData[row][col] = imageData[row][image.getWidth() - col - 1];
                imageData[row][image.getWidth() - col - 1] = temp;
            }
        }
        image.setData(imageData);
    }
}

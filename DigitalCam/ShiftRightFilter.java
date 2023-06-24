
/**
 * A filter that shifts the entire image to right right by one pixel to make it look like the image itself is scrolling to the right
 *
 * @author Comingupwithnames
 * @version 1
 */
public class ShiftRightFilter implements Filter
{
    public void filter(PixelImage image)
    {
        Pixel[][] imageData = image.getData(); //gets the image data
        Pixel[][] tempArray = new Pixel[image.getHeight()][image.getWidth()];//Creates a temp array with the same dimensions as the imageData array
        for(int row = 0; row<image.getHeight() ;row++)
        {
            for(int col = 0; col<image.getWidth(); col++)
            {
                tempArray[row][(col+1)%image.getWidth()] = imageData[row][col]; //Uses the modulo operator to shift every column to the right by one and anything outside the bounds will get put back at 0
            }
        }
        imageData = tempArray;
        image.setData(imageData);

    }
}

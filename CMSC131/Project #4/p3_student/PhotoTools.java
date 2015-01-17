package p3_student;


import photo.Photograph;
import photo.Pixel;

/**
 * This class will be written by you.  It provides various
 * static methods that take a photograph and produce a copy of it with
 * various modifications.
 * 
 * See the project description for details of method implementations.
 * 
 * Purpose: To alter four photos in a variety of ways.
 * Author: Eric Lancaster
 * Section: 0404
 * TA: Xuetong Sun
 */
public class PhotoTools {
	
	/**
	 * Purpose: To take a copy of a photo.
	 * @param photo: Photo object to alter.
	 * @return: Return copied photo.
	 */
	public static Photograph copy(Photograph photo) {
		int photoWidth = photo.getWidth();
		int photoHeight = photo.getHeight();
		Photograph newPhoto = new Photograph(photoWidth, photoHeight);
		
		for (int row = 0; row < photoHeight; row++){
			for (int column = 0; column < photoWidth; column++){
				Pixel movingPixel = photo.getPixel( column, row );
				newPhoto.setPixel( column, row, movingPixel );
			}
		}
		return newPhoto;
	}

	/**
	 * Purpose: To create a copy of a photo and convert
	 * its color to gray only.
	 * @param photo: Photo object to alter.
	 * @return: Return grayscale copy of original photo.
	 */
	public static Photograph makeGrayscale(Photograph photo) {
		int photoWidth = photo.getWidth();
		int photoHeight = photo.getHeight();
		Photograph copyPhoto = copy( photo );
		
		for ( int row = 0; row < photoHeight; row++ ){
			for ( int column = 0; column < photoWidth; column++ ){
				Pixel anyPx = photo.getPixel( column, row );
				
				int grayInt = anyPx.getRed() * 25 / 100 
						+ anyPx.getGreen() * 60 / 100 
						+ anyPx.getBlue() * 15 / 100;
				
				Pixel grayPixel = new Pixel( grayInt, grayInt, grayInt );
				copyPhoto.setPixel( column, row, grayPixel );
			}
		}
		return copyPhoto;
	}
	/**
	 * Purpose: To place patterned black grids on a photo.
	 * @param photo: Photo object to alter.
	 * @return: Return gridded copy of original photo.
	 */
	public static Photograph gridded( Photograph photo ) {
		Photograph photoCopy = copy( photo );
		int photoWidth = photo.getWidth();
		int photoHeight = photo.getHeight();
		Pixel blackPixel = new Pixel( 0, 0, 0 );
		
		// colStrip specifies how many 'strips' of 10 pixels we have in a column
		for ( int colStrip = 0; colStrip < ( photoHeight / 10 ); colStrip++ ){
			if ( colStrip % 2 != 0 ){
				
				// rowStrip specifies how many 'strips' of 10 pixels we have in a row
				for ( int rowStrip = 0; rowStrip < ( photoWidth / 10 ); rowStrip++ ){
					
					if (rowStrip % 2 != 0 ){
						// for black boxes that may exist on edge of screen since
						// perfectly dividing photo dimensions by 10 may not be possible
						for ( int x = ( rowStrip*10 ); x < ( ( rowStrip*10 ) + 10 ); x++){
							for ( int y = ( colStrip*10 ); y < ( ( colStrip*10 ) + 10 ); y++){
								photoCopy.setPixel( x, y, blackPixel );
						}
					}
				}
			}
		}
		
	}
	return photoCopy;
}
	
	public static Photograph isolateColor(Photograph photo, int type) {
		// REMOVE THE LINE OF CODE BELOW THIS COMMENT WHEN YOU IMPLEMENT THIS
		throw new RuntimeException("NOT YET IMPLEMENTED");
	}
	/**
	 * Purpose: Stretch a photo either horizontally or vertically
	 * by doubling pixel amount in x or y direction.
	 * @param photo: Photo object to alter.
	 * @param type: Specify horizontal or vertical stretch
	 * @return: Return stretched photo.
	 */
	public static Photograph stretched( Photograph photo, int type ) {
		int photoHeight = photo.getHeight();
		int photoWidth = photo.getWidth();
		Photograph sizedPhoto;
		
		if ( type == 0 ){
			sizedPhoto = new Photograph( photoWidth*2, photoHeight );
			for ( int column = 0; column < photoWidth; column++ ){
				for ( int row = 0; row < photoHeight; row++ ){
					Pixel copyPixel = photo.getPixel( column, row );
					sizedPhoto.setPixel( column * 2, row, copyPixel );
					sizedPhoto.setPixel( ( column * 2 ) + 1, row, copyPixel );
				}
			}
		} else {
			// assume type to be 1
			sizedPhoto = new Photograph(photoWidth, photoHeight*2);
			for ( int row = 0; row < photoHeight; row++ ){
				for ( int column = 0; column < photoWidth; column++ ){
					Pixel copyPixel = photo.getPixel( column, row );
					sizedPhoto.setPixel( column, ( row * 2 ), copyPixel );
					sizedPhoto.setPixel( column, ( row * 2 ) + 1, copyPixel );
				}
			}
		}
		return sizedPhoto;
	}

	/**
	 * Purpose: Horizontally and vertically stretch a photo.
	 * @param photo: Photo object to alter.
	 * @return: Return enlarged photo.
	 */
	public static Photograph enlargement( Photograph photo ) {
		Photograph copyPhoto = copy( photo );
		copyPhoto = stretched( copyPhoto, 0 );
		copyPhoto = stretched( copyPhoto, 1 );
		return copyPhoto;
	}
	/**
	 * Purpose: To take a copy of a photo and rotate it
	 * 90 degrees onto its side.
	 * @param photo: Photo object to alter.
	 * @return: Return now rotated photo.
	 */
	public static Photograph rotated( Photograph photo ) {
		int photoHeight = photo.getHeight();
		int photoWidth = photo.getWidth();
		Photograph copyPhoto = new Photograph( photoHeight, photoWidth );
		
		for ( int column = 0; column < photoWidth ; column++ ){
			for ( int row = photoHeight - 1; row >= 0; row-- ){
				Pixel movingPixel = photo.getPixel( column, row );
				copyPhoto.setPixel( photoHeight - 1 - row, column, movingPixel );
			}
		}
		return copyPhoto;
	}
	/**
	 * Purpose: To take a copy of a photo and turn it upside down.
	 * @param photo: Photo object to alter
	 * @return: Return upside down copy of original photo.
	 */
	public static Photograph upsideDown( Photograph photo ) {
		int photoHeight = photo.getHeight();
		int photoWidth = photo.getWidth();
		Photograph copyPhoto = copy( photo );
		
		for (int column = 0; column < photoWidth ; column++){
			for (int row = 0; row < photoHeight; row++){
				Pixel movingPixel = photo.getPixel(column,row);
				copyPhoto.setPixel( photoWidth - column - 1,photoHeight - row - 1, movingPixel );
			}
		}
		return copyPhoto;
	}

	/**
	 * Purpose: Take the original photo and make two copies, one 
	 * upside down, the other rotated, and merge them into 
	 * one photo where any empty pixels are black.
	 * @param photo: Photo object to alter.
	 * @return: Return the new merged photo.
	 */
	public static Photograph weirdCombo(Photograph photo) {
		Photograph upsideDownPhoto = upsideDown(photo);
		Photograph rotatedPhoto = rotated(photo);
		int combinedWidth = photo.getHeight() + photo.getWidth();
		int mergedHeight;
		
		if ( photo.getHeight() > photo.getWidth()){
			mergedHeight = photo.getHeight();
		}else{
			mergedHeight = photo.getWidth();
		}
		
		// color the whole photo black
		Photograph mergedPhoto = new Photograph( combinedWidth, mergedHeight );
		for( int column = 0; column < mergedPhoto.getWidth(); column++ ){
			for( int row = 0; row < mergedPhoto.getHeight(); row++ ){
				Pixel blackPixel = new Pixel( 0, 0, 0 );
				mergedPhoto.setPixel( column, row, blackPixel );
			}
		}
		
		// insert the upside-down photo by examining
		// its dimensions within merged photo's dimensions
		for ( int column = 0; column < upsideDownPhoto.getWidth(); column++ ){
			for ( int row = 0; row < upsideDownPhoto.getHeight(); row++ ){
				Pixel movingPixel = upsideDownPhoto.getPixel( column, row );
				mergedPhoto.setPixel( column, row, movingPixel );
			}
		}
		// insert the rotated photo by examining its dimensions
		// within the merged photo's dimensions
		for ( int column = upsideDownPhoto.getWidth(); column < mergedPhoto.getWidth(); column++ ){
			for ( int row = 0; row < rotatedPhoto.getHeight(); row++ ){
				Pixel movingPixel = rotatedPhoto.getPixel( column - upsideDownPhoto.getWidth(), row );
				mergedPhoto.setPixel( column, row, movingPixel );
			}
		}
		return mergedPhoto;
	}


}

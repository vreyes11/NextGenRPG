package org.rpg.map;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Space implements TileIndex{

	////////////////
	// spriteIndex
	////////////////
	// 0 -> grass
	// 1 -> rock
	// 2 -> water
	// ...
	private int spriteIndex;
	private BufferedImage image;
	// NOTE: Images are in /bin/res/
	private String grassLoc = "grass.png";
	private String waterLoc = "water.png";
	private String rockLoc = "rock.png";
	private String dirtLoc = "dirt.png";
	private String pathLoc = "path.png";
	private String treeLoc = "oak.png";
	
	private boolean hasTreasure;
	private boolean hasNPC;
	private boolean hasWall;
	private boolean hasTrap;
	private boolean hasTerrain;
	private boolean hasPlayer;
	
	// grass, no obstacle space
	public Space() {
		spriteIndex = 0;
		loadImageFromFile(grassLoc);
		hasTreasure = false;
		hasNPC = false;
		hasWall = false;
		hasTrap = false;
		hasTerrain = false;
		hasPlayer = false;
	}
	
	public Space(int spriteIndex) {
		this.setSpriteIndex(spriteIndex);
		switch(spriteIndex) {
		case GRASS_INDEX:
			// grass
			loadImageFromFile(grassLoc);
			break;
		case ROCK_INDEX: 
			// rock
			loadImageFromFile(rockLoc);
			hasTerrain = true;
			break;
		case WATER_INDEX: 
			// water
			loadImageFromFile(waterLoc);
			hasTerrain = true;
			break;
		case DIRT_INDEX: 
			loadImageFromFile(dirtLoc);
			break;
		case PATH_INDEX: 
			loadImageFromFile(pathLoc);
			break;
		case TREE_INDEX:
			loadImageFromFile(treeLoc);
			hasTerrain = true;
			break;
		default:
			// grass
			loadImageFromFile(grassLoc);
			break;
		}
	}
	
	// takes a fileLocation string and instantiates the private member variable image
    public void loadImageFromFile(String fileName) {
    	try {    		
    		// NOTE: Images are in /bin/res/
    		image = ImageIO.read(this.getClass().getResource("/res/tiles/" + fileName));
    		//setImage(ImageIO.read(new File(fileLocation)));

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public BufferedImage getImageFromFile(String image) {
    	String location = "";
    	switch(image) {
    	case "tree":
    		location = treeLoc;
    		break;
    	}
    	try {    		
    		return ImageIO.read(this.getClass().getResource("/res/tiles/" + location));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
    }
    
    public BufferedImage getImage() { return image; }

	public void setImage(BufferedImage image) { this.image = image; }
	
	
	public int getSpriteIndex() { return spriteIndex; }

	public void setSpriteIndex(int spriteIndex) { this.spriteIndex = spriteIndex; }
	
	public boolean hasTreasure() { return hasTreasure; }
	
	public boolean hasNPC() { return hasNPC; }
	
	public boolean hasWall() { return hasWall; }
	
	public boolean hasTrap() { return hasTrap; }
	
	public boolean hasTerrain() { return hasTerrain; }
	
	public boolean hasPlayer() { return hasPlayer; }
	
	public void setHasPlayer(Boolean tf) { hasPlayer = tf; }

}


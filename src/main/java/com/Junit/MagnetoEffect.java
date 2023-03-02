package com.Junit;

import java.security.KeyStore.Entry;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry.*;
import java.util.stream.Stream;

public class MagnetoEffect {
	
	private List<Point> anchors = new ArrayList<Point>();
	
	public Point check(Point point) {
		
		Point nearestAnchor = findNearestAnchorFor(point);
		
		if(nearestAnchor == null) {
			return point;
		} else {
			return nearestAnchor;
		}
		
	}

	private Point findNearestAnchorFor(Point point) {		
		double nearestDistance = Double.MAX_VALUE;
		Point nearestAnchor = null;
		for(Point anchor: anchors) {
			double distance =  Math.pow(anchor.getX() - point.getX(), 2) + Math.pow(anchor.getY() - point.getY(), 2);
			if(distance <= Math.pow(5, 2)) {
				if(distance < nearestDistance) {
					nearestAnchor = anchor;
					nearestDistance = distance;
				}
			}
		}
		return nearestAnchor;
	}

	private SimpleEntry<Point, Double> simpleEntry(Point anchor, Point point) {
		return new AbstractMap.SimpleEntry<Point, Double>(anchor, getDistance(anchor, point));
	}

	public void addAnchor(Point point) {
		this.anchors.add(point);
	}
	
	private double getDistance(Point anchor, Point point) {
		return Math.pow(anchor.getX() - point.getX(), 2) + Math.pow(anchor.getY() - point.getY(), 2);
	}
	
	

}

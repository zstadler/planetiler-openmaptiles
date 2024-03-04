package org.openmaptiles.util;

import com.onthegomap.planetiler.reader.SourceFeature;
import com.onthegomap.planetiler.reader.osm.OsmElement;
import com.onthegomap.planetiler.reader.osm.OsmSourceFeature;

public class FeatureId {

  private FeatureId() {}

  public static long create(SourceFeature sf) {
    if (sf instanceof OsmSourceFeature osmFeature) {
      long elemType;
      var element = osmFeature.originalElement();
      if (element instanceof OsmElement.Relation) {
        elemType = 4;
      } else if (element instanceof OsmElement.Way) {
        elemType = 1;
      } else {
        elemType = 0;
      }
      return elemType + element.id() * 10;
    }
    return sf.id();
  }
}

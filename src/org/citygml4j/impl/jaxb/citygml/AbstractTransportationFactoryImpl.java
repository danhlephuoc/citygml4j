package org.citygml4j.impl.jaxb.citygml;

import org.citygml4j.impl.jaxb.citygml.transportation._0_4.Transportation040FactoryImpl;
import org.citygml4j.impl.jaxb.citygml.transportation._1.Transportation100FactoryImpl;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficArea;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.Railway;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.citygml.transportation.Square;
import org.citygml4j.model.citygml.transportation.Track;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.citygml.transportation.TrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.TransportationComplex;
import org.citygml4j.model.citygml.transportation.TransportationFactory;
import org.citygml4j.model.citygml.transportation.TransportationModule;

public abstract class AbstractTransportationFactoryImpl implements TransportationFactory {
	private static Transportation040FactoryImpl factory040 = new Transportation040FactoryImpl();
	private static Transportation100FactoryImpl factory100 = new Transportation100FactoryImpl();
	
	public static TransportationFactory getInstance(TransportationModule module) {
		switch (module) {
		case v0_4_0:
			return factory040;
		default:
			return factory100;
		}
	}
	
	public abstract AuxiliaryTrafficArea createAuxiliaryTrafficArea();

	public abstract AuxiliaryTrafficAreaProperty createAuxiliaryTrafficAreaProperty();

	public abstract Railway createRailway();

	public abstract Road createRoad();

	public abstract Square createSquare();

	public abstract Track createTrack();

	public abstract TrafficArea createTrafficArea();

	public abstract TrafficAreaProperty createTrafficAreaProperty();

	public abstract TransportationComplex createTransportationComplex();

}
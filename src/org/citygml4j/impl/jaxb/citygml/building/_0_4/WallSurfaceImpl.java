package org.citygml4j.impl.jaxb.citygml.building._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.citygml._0_4.WallSurfaceType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.WallSurface;

public class WallSurfaceImpl extends BoundarySurfaceImpl implements WallSurface {
	private WallSurfaceType wallSurfaceType;

	public WallSurfaceImpl() {
		this(new WallSurfaceType());
	}

	public WallSurfaceImpl(WallSurfaceType wallSurfaceType) {
		super(wallSurfaceType);
		this.wallSurfaceType = wallSurfaceType;
	}

	@Override
	public WallSurfaceType getJAXBObject() {
		return wallSurfaceType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.WALLSURFACE;
	}

	public void addGenericApplicationPropertyOfWallSurface(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			wallSurfaceType.get_GenericApplicationPropertyOfWallSurface().add(jaxbElem);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfWallSurface() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : wallSurfaceType.get_GenericApplicationPropertyOfWallSurface()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	public void setGenericApplicationPropertyOfWallSurface(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			wallSurfaceType.unset_GenericApplicationPropertyOfWallSurface();
			wallSurfaceType.get_GenericApplicationPropertyOfWallSurface().addAll(elemList);
		}
	}

	public boolean isSetGenericApplicationPropertyOfWallSurface() {
		return wallSurfaceType.isSet_GenericApplicationPropertyOfWallSurface();
	}

	public void unsetGenericApplicationPropertyOfWallSurface() {
		wallSurfaceType.unset_GenericApplicationPropertyOfWallSurface();
	}

	public boolean unsetGenericApplicationPropertyOfWallSurface(ADEComponent adeObject) {
		if (wallSurfaceType.isSet_GenericApplicationPropertyOfWallSurface()) {
			Iterator<JAXBElement<?>> iter = wallSurfaceType.get_GenericApplicationPropertyOfWallSurface().iterator();
			while (iter.hasNext()) {
				JAXBElement<?> elem = iter.next();
				if (elem.getValue() != null && elem.getValue() != null) {
					JAXBElement<?> ade = ModelMapper.ADE.toJAXB(adeObject);
					if (ade != null && ade.getValue() != null && elem.getValue().equals(ade.getValue())) {
						iter.remove();
						return true;
					}
				}
			}				
		}

		return false;
	}

}
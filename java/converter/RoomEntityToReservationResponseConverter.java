package converter;

import org.springframework.core.convert.converter.Converter;

import com.Arvind.Fullstack.Response.Links;
import com.Arvind.Fullstack.Response.ReservationResponse;
import com.Arvind.Fullstack.Response.Self;
import com.Arvind.learning.entity.RoomEntity11;

public class RoomEntityToReservationResponseConverter implements Converter<RoomEntity11,ReservationResponse>{

	@Override
	public ReservationResponse convert(RoomEntity11 source) {
		// TODO Auto-generated method stub
		
		ReservationResponse reservationResponse=new ReservationResponse();
		reservationResponse.setRoomnumber(source.getRoomNumber());
		reservationResponse.setPrice(Integer.valueOf(source.getPrice()));
		
		Links links=new Links();
		Self self=new Self();
		self.setRef(ResourceConstants.Room_Reservation+"/"+source.getId());
		links.setSelf(self);
		reservationResponse.setLink(links);
		
		return reservationResponse;
	}

}

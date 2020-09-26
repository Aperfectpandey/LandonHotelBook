package converter;

import org.springframework.core.convert.converter.Converter;

import com.Arvind.Fullstack.Response.Request.ReservationRequest;
import com.Arvind.learning.entity.ReservationEntity;

public class NewReservationRequestToReservationEntityConverter implements Converter<ReservationRequest, ReservationEntity>{
	public ReservationEntity convert(ReservationRequest source) {
		ReservationEntity reservationEntity=new ReservationEntity();
		reservationEntity.setCheckin(source.getCheckin());
		reservationEntity.setCheckout(source.getCheckout());
		
		if(null != source.getId()) {
			reservationEntity.setId(source.getId());
		}
		return reservationEntity;
	}
	
	
}

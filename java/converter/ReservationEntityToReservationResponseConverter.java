package converter;

import org.springframework.core.convert.converter.Converter;

import com.Arvind.Fullstack.Response.ReservationResponse;
import com.Arvind.learning.entity.ReservationEntity;

public class ReservationEntityToReservationResponseConverter implements Converter<ReservationEntity, ReservationResponse>{
@Override
public ReservationResponse convert(ReservationEntity source) {
	// TODO Auto-generated method stub
	ReservationResponse reservationResponse=new ReservationResponse();
	reservationResponse.setCheckin(source.getCheckin());
	reservationResponse.setCheckout(source.getCheckout());
	return reservationResponse;
}
}

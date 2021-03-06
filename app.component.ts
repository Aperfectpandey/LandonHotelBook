import { Component,OnInit } from '@angular/core';
import { FormControl,FormGroup} from '@angular/forms';
import { Http,Response } from @angular/http;
import { Observable } from "rxjs/Rx";
import "rxjs/add/operator/map"
import "rxjs/add/operator/catch"
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  constructor(private http:Http){}

  private baseUrl:string='http://localhost:8080';
  public submitted:boolean;
  roomsearch:FormGroup;
  rooms: Room[];
  currentCheckInVal:string;
  currentCheckOutVal:string;

  ngOnInit(){
    this.roomsearch=new FormGroup({
      checkin:new FormControl(' '),
      checkout:new FormControl(' ')
    });
    const roomsearchValueChangesS=this.roomsearch.valueChanges;
    
    roomsearchValueChangesS.subscribe(valChange=>{
      this.currentCheckInVal=valChange.checkin;
      this.currentCheckOutVal=valChange.checkout;
    })
  }

  onSubmit({value,valid}:{value:Roomsearch,valid:boolean}){
    this.getAll()
      .subscribe(rooms=>this.rooms=rooms,
          err=>{console.log(err);})
    console.log(value);
  }
  reserveRoom(value:string){
    this.request=new ReserveRoomRequest(value,this.currentCheckInVal,this.currentCheckOutVal)
  }
   
  getAll():Observable<Room[]>{
    return this.http.get(this.baseUrl+'/room/reservation/v1?checkin=' +this.currentCheckInVal+ '&checkout='+this.currentCheckOutVal);
    .map(this.mapRoom);
  }
  createReservation(body:ReserveRoomRequest){
    let bodyString=JSON.stringify(body);
    let headers=new Headers({'Content-Type':'application/json'});
    let option=new RequestOptions({headers:headers});

    this.http.post(this.baseUrl+'/room/reservation/v1',body,option).subscribe(res=>console.log(res));
  }
  mapRoom(response:Response):Room[]{
    return response.json().content;
  }

  title = 'angular';
}
export interface Roomsearch{
  checkin:string;
  checkout:string;
}
export interface Room{
  id:string;
  roomNumber:string;
  price:string;
  links:string;
}
export class reserveRoomRequest{
  roomId:string;
  checkin:string;
  checkout:string;

    constructor(
      roomId:string,
  checkin:string,
  checkout:string
    ){
      this.roomId=roomId;
      this.checkin=checkin;
      this.checkout=checkout;
    }
}


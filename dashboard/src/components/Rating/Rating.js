import React, { Component } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

class Rating extends Component{

	render(){
        const list = this.props.list;
        const r1 = this.props.r1;
        const r2 = this.props.r2;
        const num = this.props.num;

        let sum = 0;
        const avg = list.map((k, v) => {
           sum += list[k];
           console.log(list[v]);
           return sum/list.length;
        });
        
        if(avg >= r1 && avg <= r2){
            return(
                <FontAwesomeIcon icon="thumbs-up" />
            );
        }else if(num){
            if(num >= r1 && num <= r1){
               return(
                <FontAwesomeIcon icon="thumbs-up" />
              ); 
            }else{
                return(
               <FontAwesomeIcon icon="thumbs-down" />
               );
            }
        }else{
		  return(
               <FontAwesomeIcon icon="thumbs-down" />
          );
	    }

        
    }
}

export default Rating;


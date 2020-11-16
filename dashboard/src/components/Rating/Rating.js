import React, { Component } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import './Rating.css';

class Rating extends Component{

	render(){
        const list = this.props.list;
        const r1 = this.props.r1;
        const r2 = this.props.r2;
        const num = this.props.num;
        const oneNum = this.props.oneNum;

        if(oneNum == true){
            if(num >= r1 && num <= r2){
              return(
                 <FontAwesomeIcon icon="thumbs-up" />
             );

            }else{
              return(
               <FontAwesomeIcon icon="thumbs-down" />
             );
            }
        }else{
            
            if(r1 === -1 && r2 === -1){
                console.log(num);
                if(num <= 0){
                    return(
                        <FontAwesomeIcon icon="thumbs-down" />
                    );
                }else{
                    return(
                        <FontAwesomeIcon icon="thumbs-up" />
                    );
                }
            }
        }
    }
}

export default Rating;


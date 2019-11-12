import React, { Component } from "react";
import CircularTimerView from './CircularTimerView';


export default class App extends Component {
  
  constructor(props){
    super(props);
    this.state = {
      text :"testing",
      color:'#ffff00',
      prefix:'prefix',
      suffix:'suffix'
    }
  }

  render() {
    return (
      <CircularTimerView
        style={{flex:1}}
        onPress={e => {
          // alert(e.nativeEvent.message);
        }}

        onTimerFinished={e => {
          // alert(e.nativeEvent.message);
          this.setState({color:'#f00'})
        }}  
        backgroundColor={this.state.color}
       
      />
   
  );
  }
}



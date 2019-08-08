import React, { Component } from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom'

import './App.css';
import CreateAccount from './Components/Account/CreateAccount'

class App extends Component {

  createAccount = (firstName, lastName) => {
    console.log(firstName);
    console.log(lastName);
    this.setState({
      firstName: firstName,
      lastName: lastName
    })
  }

  render() {
    return (
      <div className="App">
        <Router>
          <header className="App-header">
            <h1>Banking App</h1>
          </header>
          <div className="App-body">
            <Route exact path={'/'} render={() => <CreateAccount />} />
            <p>this is body</p>
          </div>
        </Router>
      </div>
    );
  }
}

export default App;

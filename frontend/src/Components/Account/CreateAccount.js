import React, { Component } from 'react';
import axios from 'axios';
import { Button, Form, FormGroup, Input, InputGroup, InputGroupAddon } from 'reactstrap';

class CreateAccount extends Component {

    constructor() {
        super()
        this.state = {
            status: "test"
        };
    }

    handleClick = (e) => {
        e.preventDefault();
        let body = {
            firstName: e.target[0].value,
            lastName: e.target[1].value,
        }

        axios.post('http://localhost:8080/createAccount', body)
            .then(() => {
                this.setState({
                    status: "Account Created"
                })
            })
            .catch(error => {
                console.log(body);
                console.log(error);
                this.setState({
                    status: "Failed to create"
                });
            })
    }

    render() {
        return (
            <div>
                <h3>Enter Your Details</h3>
                <Form onSubmit={this.handleClick}>
                    <FormGroup row>
                        <InputGroup>
                            <InputGroupAddon addonType="prepend">First Name</InputGroupAddon>
                            <Input placeholder="First Name" />
                        </InputGroup>
                    </FormGroup>
                    <br></br>
                    <FormGroup row>
                        <InputGroup>
                            <InputGroupAddon addonType="prepend">Last Name</InputGroupAddon>
                            <Input placeholder="Last Name" />
                        </InputGroup>
                    </FormGroup>
                    <br></br>
                    <Button>Submit</Button>
                </Form>
                <p>{this.state.status}</p>
            </div>
        );
    }

}
export default CreateAccount;
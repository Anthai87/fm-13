package org.RedGreenRefactor;

import java.util.ArrayList;
import java.util.List;

import dtu.redGreenRefactor.main.model.Payment;
import dtu.redGreenRefactor.main.model.Person;

public class HelloService {
	
		private List<Payment> payments = new ArrayList<>();
		private List<Person> persons = new ArrayList<>();
		public List<Person> getPersons() {
			return persons;
		}

		public HelloService() {
			Person p1 = new Person("John", "Doe");
			p1.setId(1);
			persons.add(p1);
			Person p2 = new Person("Alice", "Andersson");
			p2.setId(2);
			persons.add(p2);

		}
		public void setPersons(List<Person> persons) {
			this.persons = persons;
		}

		public List<Payment> getPayments() {
			return payments;
		}

		public void setPayments(List<Payment> payments) {
			this.payments = payments;
		}
		public void addPerson(Person person) {
			persons.add(person);
		}
		public boolean existsPerson(int id) {
			for (Person person : getPersons()) {
				if (person.getId() == id) {
					return true;
				}
			}
			return false;
		}

		public void addPayment(Payment payment) {
			payments.add(payment);
		}
	}



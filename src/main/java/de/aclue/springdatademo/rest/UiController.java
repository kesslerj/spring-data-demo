package de.aclue.springdatademo.rest;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.aclue.springdatademo.persistence.entity.Customer;
import de.aclue.springdatademo.service.CustomerService;

@Controller
public class UiController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UiController.class);

	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView dbData() {
		Map<String, Object> model = new LinkedHashMap<>();

		Object currentQueryResult = customerService.currentQuery();
		if (isListOfCustomer(currentQueryResult)) {
			model.put("currentResults", currentQueryResult);
		}
		else if (currentQueryResult instanceof Customer) {
			model.put("currentResults", Arrays.asList(currentQueryResult));
		}
		else{
			LOGGER.info("currentQueryResult is not a List<Customer>, returning currentQueryResult.toString()");
			model.put("singleResult", currentQueryResult.toString());
		}
		model.put("allResults", customerService.allCustomers());
		return new ModelAndView("summary", model);
	}

	private boolean isListOfCustomer(Object object) {
		return object instanceof List
				&& !((List<?>) object).isEmpty()
				&& ((List<?>) object).get(0) instanceof Customer;
	}

}

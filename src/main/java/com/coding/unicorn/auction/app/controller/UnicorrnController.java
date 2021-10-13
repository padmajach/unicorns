package com.coding.unicorn.auction.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coding.unicorn.auction.app.jpa.UnicornJpaRespository;
import com.coding.unicorn.auction.app.vo.Unicorn;

@RestController
public class UnicorrnController {

	@Autowired
	private UnicornJpaRespository unicornJpaRespository;

	@GetMapping("/unicorns")
	public ResponseEntity<List<Unicorn>> getAllUnicorns() {

		try {
			List<Unicorn> unicorns = new ArrayList<Unicorn>();

			unicorns = unicornJpaRespository.findAll();

			if (unicorns.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(unicorns, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/unicorns/{unicornId}")
	public ResponseEntity<Unicorn> getUnicornBasedOnId(@PathVariable("unicornId") long unicornId) {

		Optional<Unicorn> unicornData = unicornJpaRespository.findById(unicornId);

		if (unicornData.isPresent()) {
			return new ResponseEntity<>(unicornData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/unicorns", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> postUnicorns(@RequestBody Unicorn unicorn) {
		try {
			Unicorn _unicorn = unicornJpaRespository.save(unicorn);
			return new ResponseEntity<String>(_unicorn.getId().toString(), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/unicorns/{unicornId}")
	public ResponseEntity<Unicorn> updateUnicorn(@PathVariable("unicornId") long unicornId,
			@RequestBody Unicorn unicorn) {

		Optional<Unicorn> unicornData = unicornJpaRespository.findById(unicornId);

		if (unicornData.isPresent()) {
			Unicorn _unicorn = unicornData.get();
			_unicorn.setEyeColor(unicorn.getEyeColor());
			_unicorn.setHairColor(unicorn.getHairColor());
			_unicorn.setHeight(unicorn.getHeight());
			_unicorn.setHeightUnit(unicorn.getHeightUnit());
			_unicorn.setHornLength(unicorn.getHornLength());
			_unicorn.setHornColor(unicorn.getHornColor());
			_unicorn.setName(unicorn.getName());
			_unicorn.setWeight(unicorn.getWeight());
			_unicorn.setWeightUnit(unicorn.getWeightUnit());
			_unicorn.setId(unicorn.getId());
			_unicorn.setIdentifiableMarks(unicorn.getIdentifiableMarks());

			return new ResponseEntity<>(unicornJpaRespository.save(_unicorn), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

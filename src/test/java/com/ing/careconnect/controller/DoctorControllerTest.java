package com.ing.careconnect.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.ing.careconnect.dto.AllDoctorsDTO;
import com.ing.careconnect.dto.DoctorsResponseDto;
import com.ing.careconnect.dto.ResponseDto;
import com.ing.careconnect.dto.SearchResponseDto;
import com.ing.careconnect.dto.SlotRequestDto;
import com.ing.careconnect.entity.Doctors;
import com.ing.careconnect.service.DoctorService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DoctorControllerTest {

	@InjectMocks
	DoctorController doctorController;

	@Mock
	DoctorService doctorService;

	AllDoctorsDTO doctorsResp = new AllDoctorsDTO();
	Doctors doctors = new Doctors();

	@Before
	public void setUp() {

		doctors.setDoctorId(1L);
		doctors.setLocation("Bangalore");
		doctors.setCategery("Heart");
		doctors.setRating("5");
	}

	@Test
	public void testGetAllDoctors() {

		Mockito.when(doctorService.getAllDoctors()).thenReturn(doctorsResp);

		ResponseEntity<AllDoctorsDTO> allDoctors = doctorController.getAllDoctors();

		Assert.assertNotNull(allDoctors);
		Assert.assertEquals(200, allDoctors.getStatusCode().value());

	}

	@Test
	public void testGetAllDoctorsBySearch() {

		List<SearchResponseDto> searchResponseDTO = new ArrayList<>();
		SearchResponseDto searchResponseDto2 = new SearchResponseDto();
		searchResponseDto2.setDoctorId(1L);
		searchResponseDto2.setName("Rajesh");
		searchResponseDto2.setRating("5");
		Mockito.when(doctorService.getAllDoctorsBySearchCreiteria(doctors.getLocation(), doctors.getCategery(),
				doctors.getSpecialist())).thenReturn(searchResponseDTO);
		ResponseEntity<List<SearchResponseDto>> allDoctorsBySearch = doctorController
				.getAllDoctorsBySearch(doctors.getLocation(), doctors.getCategery(), doctors.getSpecialist());
		Assert.assertNotNull(allDoctorsBySearch);
		Assert.assertEquals(200, allDoctorsBySearch.getStatusCode().value());
	}

	@Test
	public void testGetBookedSlots() {

		DoctorsResponseDto doctorsResponseDTO = new DoctorsResponseDto();
		doctorsResponseDTO.setDoctors(Optional.of(doctors));

		Mockito.when(doctorService.getBookedSlots(1L)).thenReturn(doctorsResponseDTO);
		ResponseEntity<DoctorsResponseDto> bookedSlots = doctorController.getBookedSlots(1L);
		Assert.assertNotNull(bookedSlots);
		Assert.assertEquals(200, bookedSlots.getStatusCode().value());

	}

	@Test
	public void testBlockSlots() {
		SlotRequestDto slotRequestDto = new SlotRequestDto();
		slotRequestDto.setBlockDate("2020-02-10");
		slotRequestDto.setFromTime("10:30");
		slotRequestDto.setToTime("12:30");
		ResponseDto responseDTO = new ResponseDto();
		responseDTO.setMessage("success");
		responseDTO.setStatusCode(200);
		Mockito.when(doctorService.blockSlots(1L, slotRequestDto)).thenReturn(responseDTO);

		ResponseEntity<ResponseDto> saveVendorItemDetails = doctorController.blockSlots(1L, slotRequestDto);

		Assert.assertNotNull(saveVendorItemDetails);
		Assert.assertEquals(200, saveVendorItemDetails.getStatusCode().value());
	}
}

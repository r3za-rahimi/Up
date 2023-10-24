package com.example.up.controller;

import com.example.up.dto.CardDto;
import com.example.up.entity.Card;
import com.example.up.service.CardService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController extends  AbstractController<Card , CardDto, CardService> {



}

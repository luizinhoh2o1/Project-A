package com.alone.projecta.resources.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alone.projecta.domain.Server;
import com.alone.projecta.dto.CommandToServerDTO;
import com.alone.projecta.dto.PlayerDTO;
import com.alone.projecta.dto.ServerDTO;
import com.alone.projecta.services.ServerService;
import com.alone.projecta.services.util.GenerateCurrentDate;

@RestController
@RequestMapping(value = "/servers")
public class ServerResource {

	@Autowired
	private ServerService serverService;
	@Autowired
	private RestTemplate restTemplate;

	private Integer defaultMonthsExpire = 3;

	// Buscar server por ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<ServerDTO> findById(@PathVariable String id) {
		Server obj = serverService.findById(id);
		return ResponseEntity.ok().body(new ServerDTO(obj));
	}

	// Inserir command no server
	@PutMapping(value = "/{token}/insert-command")
	public ResponseEntity<Void> insertCommandToServer(@RequestBody CommandToServerDTO objCmdDTO, @PathVariable String token) {
		serverService.insertCommandToServer(objCmdDTO, token);
		return ResponseEntity.noContent().build();
	}

	// Buscar command e remover command
	@GetMapping(value = "/{token}/get-command")
	public ResponseEntity<CommandToServerDTO> getCommandToServer(@PathVariable String token) {
		Server obj = serverService.findByTokenServer(token);
		CommandToServerDTO command = obj.getCmdToServer();
		if (command.getCommand() != "") {
			obj.getCmdToServer().setCommand("");
			serverService.update(obj);
		}
		return ResponseEntity.ok().body(command);
	}

	// Listar todos os Servers
	@GetMapping
	public ResponseEntity<List<ServerDTO>> findAll() {
		List<Server> list = serverService.findAll();
		List<ServerDTO> listDTO = list.stream().map(x -> new ServerDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	// Deletar Server por ID
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable String id) {
		serverService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	// Atualizar dados do Server por ID
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody ServerDTO objDto, @PathVariable String id) {
		Server obj = serverService.fromDTO(objDto);
		obj.setId(id);
		obj = serverService.update(obj);
		return ResponseEntity.noContent().build();
	}

	// Inserir Player no Server
	@PutMapping(value = "/{token}/insert-player")
	public ResponseEntity<Void> insertPlayerServer(@RequestBody PlayerDTO objDto, @PathVariable String token) {
		/*
		 * Verifica se existe um player com o mesmo nick se nao existir, sera criado um
		 * novo player no DB
		 */
		if (!serverService.playerExists(objDto.getNickname())) {
			objDto.setExpiration(GenerateCurrentDate.getCurrentDateAndExtendMonths(defaultMonthsExpire));
			serverService.insertPlayerServer(objDto, token);
		}
		return ResponseEntity.noContent().build();
	}
	
	// Consome API e retorna status do server
	@GetMapping("/server-status/{ip}")
	public ResponseEntity<Object> getStatus(@PathVariable String ip, @AuthenticationPrincipal UserDetails userDetails) {
		String url = "https://api.mcsrvstat.us/2/" + ip;
		Object obj = restTemplate.getForObject(url, Object.class);
		return ResponseEntity.ok().body(obj);
	}
}

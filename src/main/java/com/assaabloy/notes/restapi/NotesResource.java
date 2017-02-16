package com.assaabloy.notes.restapi;

import com.assaabloy.notes.domain.Note;
import com.assaabloy.notes.domain.NotesList;
import com.assaabloy.notes.repository.NotesRepository;
import io.dropwizard.jersey.params.IntParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

@Path("/{user}/notes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class NotesResource {

    private final NotesRepository notesRepository;

    public NotesResource(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @GET
    public NotesList findAllNotesForUser(@PathParam("user") IntParam userId) {
        final List<Note> notes = notesRepository.findAllNotesForUser(userId.get());
        if (notes != null) {
            return new NotesList(userId, notes);
        }
        else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    @POST
    public Response addNoteToUser(@PathParam("user") IntParam userId,
                        @NotNull @Valid Note note) {
        final long id = notesRepository.add(userId.get(), note);
        return Response.created(UriBuilder.fromResource(NotesResource.class)
                .build(userId.get(), id))
                .build();
    }
}
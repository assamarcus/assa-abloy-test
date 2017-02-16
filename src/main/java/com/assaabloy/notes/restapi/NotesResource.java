package com.assaabloy.notes.restapi;

import com.assaabloy.notes.repository.NotesRepository;
import com.assaabloy.notes.representations.Note;
import com.assaabloy.notes.representations.NotesList;
import io.dropwizard.jersey.params.LongParam;

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
    public NotesList findAllNotesForUser(@PathParam("user") LongParam userId) {
        final List<Note> notes = notesRepository.findAllNotesForUser(userId.get().longValue()).getNotes();
        if (notes != null) {
            return new NotesList(userId, notes);
        }
        else { /* TODO: exceptions maybe thrown above if user does not exist, will result in 500,
         no notes will result in 404 */
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    @POST
    public Response addNoteToUser(@PathParam("user") LongParam userId,
                        @NotNull @Valid Note note) {
        final long id = notesRepository.addNote(userId.get().longValue(), note);
        return Response.created(UriBuilder.fromResource(NotesResource.class)
                .build(userId.get(), id))
                .build();
    }
}
CREATE UNIQUE INDEX events_slug_key on events(slug);
CREATE UNIQUE INDEX atendees_events_id_email_key ON atendees(event_id, email);
CREATE UNIQUE INDEX check_ins_attendee_id_key ON check_ins (atendee_id);